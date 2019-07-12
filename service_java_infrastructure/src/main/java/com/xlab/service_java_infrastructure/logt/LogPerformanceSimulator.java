/*
 * module: fundermental
 * file: LogPerformaceSimulator.java
 * date: 7/12/19 10:05 AM
 * author: VectorJu
 */

/**
 * @create 2019-07-12 10:05
 * @desc test improve performance of logback param write
 * 参考自 https://mp.weixin.qq.com/s?__biz=MjM5NzMyMjAwMA==&mid=2651484309&idx=1&sn=1eb10dfa35799aa4e7befef4916aaa6a&chksm=bd251cea8a5295fc0e6ae14639a42282813f8ab9a85aed5fc3bc51c16c5f7d50134af3d937ab&mpshare=1&scene=1&srcid=0712gQg60AK2PsUlTPvP1ECo&rd2werd=1#wechat_redirect
 **/
package com.xlab.service_java_infrastructure.logt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * 日志不同级别的使用
 *
 * ERROR:基本概念
 * 影响到程序正常运行、当前请求正常运行的异常情况：
 * 1.文件操作失败
 * 2.对接第三方的异常
 * 3.所有影响功能使用的异常，包括:SQLException和除了业务异常之外的所有异常(RuntimeException和Exception)
 * 不应该出现的情况:比如要使用Azure传图片，但是Azure未响应.如果有Throwable信息，需要记录完成的堆栈信息:
 * 如果进行了抛出异常操作，请不要记录error日志，由最终处理方进行处理：
 * eg. Do Not Do this !!!
 * try{
 *      ....
 *  }catch(Exception ex){
 *        String errorMessage=String.format("Error while reading information of user [%s]",userName);
 *        logger.error(errorMessage,ex);
 *        throw new UserServiceException(errorMessage,ex);
 * }
 *
 * WARN:基本概念
 * 不应该出现但是不影响程序、当前请求正常运行的异常情况:1.有容错机制的时候出现的错误情况 2.找不到配置文件，但是系统能自动创建配置文件
 * 即将接近临界值的时候，例如：缓存池占用达到警告线
 * 业务异常的记录,比如:当接口抛出业务异常时，应该记录此异常
 * INFO:基本概念
 * 系统运行信息 1.Service方法中对于系统/业务状态的变更 2.主要逻辑中的分步骤
 * 外部接口部分 1.客户端请求参数(REST/WS) 2.调用第三方时的调用参数和调用结果
 * 并不是所有的service都进行出入口打点记录,单一、简单service是没有意义的(job除外,job需要记录开始和结束,)。
 * eg. Do not Do this !!!
 * public List listByBaseType(Integer baseTypeId) {
 *        log.info("开始查询基地");
 *          BaseExample ex=new BaseExample();
 *          BaseExample.Criteria ctr = ex.createCriteria();
 *          ctr.andIsDeleteEqualTo(IsDelete.USE.getValue());
 *          Optionals.doIfPresent(baseTypeId, ctr::andBaseTypeIdEqualTo);
 *          log.info("查询基地结束");
 *        return baseRepository.selectByExample(ex);
 * }
 * 对于复杂的业务逻辑，需要进行日志打点，以及埋点记录，比如电商系统中的下订单逻辑，以及OrderAction操作(业务状态变更)。
 * 对于整个系统的提供出的接口(REST/WS)，使用info记录入参。
 * 如果所有的service为SOA架构，那么可以看成是一个外部接口提供方，那么必须记录入参。
 * 调用其他第三方服务时，所有的出参和入参是必须要记录的(因为你很难追溯第三方模块发生的问题)。
 *
 * DEBUG:基本概念 1.可以填写所有的想知道的相关信息(但不代表可以随便写，debug信息要有意义,最好有相关参数) 2.生产环境需要关闭DEBUG信息 3.如果在生产情况下需要开启DEBUG,需要使用开关进行管理，不能一直开启
 * 如果代码中出现以下代码，可以进行优化:
 * //1. 获取用户基本薪资
 * //2. 获取用户休假情况
 * //3. 计算用户应得薪资
 * 优化后的代码:
 * logger.debug("开始获取员工[{}] [{}]年基本薪资",employee,year);
 * logger.debug("获取员工[{}] [{}]年的基本薪资为[{}]",employee,year,basicSalary);
 * logger.debug("开始获取员工[{}] [{}]年[{}]月休假情况",employee,year,month);
 * logger.debug("员工[{}][{}]年[{}]月年假/病假/事假为[{}]/[{}]/[{}]",employee,year,month,annualLeaveDays,sickLeaveDays,noPayLeaveDays);
 * logger.debug("开始计算员工[{}][{}]年[{}]月应得薪资",employee,year,month);
 * logger.debug("员工[{}] [{}]年[{}]月应得薪资为[{}]",employee,year,month,actualSalary);
 *
 * TRACE:基本概念
 * 特别详细的系统运行完成信息，业务代码中，不要使用.(除非有特殊用意，否则请使用DEBUG级别替代)
 * 规范示例说明：
 * @Override
 * @Transactional
 * public void createUserAndBindMobile(@NotBlank String mobile, @NotNull User user) throws CreateConflictException{
 *      boolean debug = log.isDebugEnabled();
 *      if(debug){
 *          log.debug("开始创建用户并绑定手机号. args[mobile=[{}],user=[{}]]", mobile, LogObjects.toString(user));
 *      }
 *      try {
 *          user.setCreateTime(new Date());
 *          user.setUpdateTime(new Date());
 *          userRepository.insertSelective(user);
 *          if(debug){
 *              log.debug("创建用户信息成功. insertedUser=[{}]",LogObjects.toString(user));
 *          }
 *          UserMobileRelationship relationship = new UserMobileRelationship();
 *          relationship.setMobile(mobile);
 *          relationship.setOpenId(user.getOpenId());
 *          relationship.setCreateTime(new Date());
 *          relationship.setUpdateTime(new Date());
 *          userMobileRelationshipRepository.insertOnDuplicateKey(relationship);
 *          if(debug){
 *              log.debug("绑定手机成功. relationship=[{}]",LogObjects.toString(relationship));
 *          }
 *          log.info("创建用户并绑定手机号. userId=[{}],openId=[{}],mobile=[{}]",user.getId(),user.getOpenId(),mobile);
 *      }catch(DuplicateKeyException e){
 *          log.info("创建用户并绑定手机号失败,已存在相同的用户. openId=[{}],mobile=[{}]",user.getOpenId(),mobile);
 *          throw new CreateConflictException("创建用户发生冲突, openid=[%s]",user.getOpenId());
 *      }
 * }
 */
public class LogPerformanceSimulator {

    private static final Logger logger = LoggerFactory.getLogger(LogPerformanceSimulator.class);


    private static void showPerformaceLog(String key,String content,int branch) {
        //不要进行字符串拼接,那样会产生很多String对象，占用空间，影响性能
        //对于debug日志，必须判断是否为debug级别后，才进行使用:
        //使用[]进行参数变量隔离

        if (branch == 1) {
            long start = System.nanoTime();
            for (int i=0;i<10000;i++) {
                if (logger.isDebugEnabled()) {
                    logger.debug("Mac Processing trade with key:[{}] and content : [{}] ", key, content);
                }
            }
            long end = System.nanoTime()-start;
            System.out.println("performance it takes " + TimeUnit.NANOSECONDS.toMillis(end));

        }else {
            long start = System.nanoTime();
            for (int i=0;i<10000;i++) {
                if (logger.isDebugEnabled()) {
                    logger.debug("Mac Processing trade with string concat key " + key + " content " + content);
                }
            }
            long end = System.nanoTime()-start;
            System.out.println("string concat takes " + TimeUnit.NANOSECONDS.toMillis(end));
        }
    }

    public static void main(String[] args) {
        showPerformaceLog("vector" ,"update user balance",1);
        //System.out.println(" it takes " + TimeUnit.NANOSECONDS.toSeconds(estimatedTime));
    }
}

