package com.lyl.cache.memcached;

import java.util.List;
import java.util.Map;

import net.rubyeye.xmemcached.Counter;


/**
 *<p>Title       :  cache的客户端的通用接口</p>
 *<p>Description :  用来对cache进行扩张,可以支持memcached eccache 等各种单机或者分布式cache实现</p>
 *<p>Datetime    :  2014年11月25日 15:24:45</p>
 *<p>@author     :  David</p>
 */
public interface MemcacheClient {

	public boolean delete(String key);
	/**
	 * 
	  * setCompressionThreshold
	  * @Description: 设置压缩阈值 512k
	  * @param  
	  * @return void
	  * @throws
	  * @author David.Cheng
	  * @date 2014年12月16日 12:12:04
	 */
	public void setCompressionThreshold();
	/**
	 * 异步删除
	 * @MethodName:asyncDelete
	 * @param key
	 * @return void
	 * @author David.Cheng
	 * @Date 2014-7-28-下午1:20:16
	 */
	public void asyncDelete(String key);

	public Object get(String key);
	  /**
     * 取出缓存数据，允许自行设置 操作的超时时间
     * @MethodName:get
     * @param key
     * @param timeout
     * @return Object
     * @author David.Cheng
     * @Date 2014-7-28-下午2:41:22
     */
	public Object get(String key,long timeout);
	/**
     * 
     * @MethodName:set 根据cachekey的组合来保存cache对象
     * @param key
     * @param cache
     * @return boolean
     * @author David.Cheng
     * @Date 2013-11-13-上午11:13:41
     */
	public boolean set(String key, Object cache, Integer expire);
	/**
     * 
     * @MethodName:set  默认有效期25小时
     * @param key
     * @param cache
     * @return
     * @return boolean
     * @author David.Cheng
     * @Date 2013-11-13-上午11:13:41
     */
	public boolean set(String key, Object cache) ;
	/**
	 * 根据cache前缀和cachekey的组合来保存cache对象
	 * @param cachePrefix   cache前缀  
	 * @param cacheKey      cachekey
	 * @param cache         保存的cache对象
	 * @return 保存结果成功 true ,失败 false
	 */
	public boolean set(String cachePrefix,String cacheKey,Object cache,Integer expire);
	
	/**
	 * @MethodName:set
	 * @param cacheKey key本身
	 * @param version 缓存对象的前缀
	 * @param cache
	 * @param timeout
	 * @param group 缓存组 与 key一起来取得一个缓存对象
	 * @return
	 * @return boolean
	 * @author David.Cheng
	 * @Date 2014-2-25-下午5:18:01
	 */
	public boolean set(String cacheKey,int version, Object cache,Integer expire,String group);
	/**
	 * @MethodName:set
	 * @param cacheKey key 
	 * @param version 缓存对象的前缀
	 * @param cache 缓存对象
	 * @param expire 有效期
	 * @return boolean
	 * @author David.Cheng
	 * @Date 2014年2月26日 10:24:47
	 */
	public boolean set(String cacheKey,int version, Object cache,Integer expire) ;
	/**
     * 异步set，没有返回值
     * @MethodName:asyncSet
     * @param key
     * @param cache
     * @param exp
     * @return void
     * @author David.Cheng
     * @Date 2014-7-28-下午12:04:09
     */
	public void asyncSet(String key, Object cache, Integer exp);
	
	public long incr(String key);
 
	
	/**
	 * 根据cache前缀和cachekey的组合来查找对象
	 * @param cachePrefix    cache前缀
	 * @param cacheKey       key
	 * @return  cache对象
	 */
	public Object get(String cachePrefix,String cacheKey);
	
	 
	
	/**
	 * 根据cache前缀和cachekey的组合来删除cache对象
	 * @param cachePrefix
	 * @param cacheKey
	 * @return
	 */
	public boolean delete(String cachePrefix,String cacheKey);
	 /**
     * 
     * @MethodName:deleteWithPrefix 根据缓存key的前缀让缓存失效
     * @param cachePrefix key的前缀
     * @return long
     * @author David.Cheng
     * @Date 2014年2月26日 10:30:03
     */
	public long deleteWithPrefix(String cachePrefix);

	/**
	 * @MethodName:batchDeleteWithGroup 根据缓存组 批量删除缓存对象
	 * @param group 缓存组
	 * @param cacheKeys 缓存key 集合
	 * @return long
	 * @author David.Cheng
	 * @Date 2014-2-26-下午4:14:30
	 */
	public boolean batchDeleteWithGroup(String group,List<String> cacheKeys) ;
  
	
 

	/**
	 * 根据 key的 增加某个值
	 * @param cachePrefix   cache前缀
	 * @param  Key      key
	 * @param num           变化的数
	 * @return
	 */
	public long incr(String key, long num);
	
	/**
	 * 刷新memcache指定ip的server的cache
	 * @param ipAddress
	 */
	public void flushServer(String ipAddress,int port);
	
	/**
	 * 刷新memcache连接的所有server的cache
	 */
	public void flushAll();

	public String getCacheObject(String cachePrefix, String cacheKey);
  
	  /**
     * 得到memcache的状态
     * @MethodName:getCacheStats
     * @return Map<String,Object>
     * @author David.Cheng
     * @Date 2014-7-18-下午1:37:14
     */
	public Map<String,Object> getCacheStats();
	
	/**
	 * 得到memcache实现的类似AtomicLong那样 操作计数
	 * @MethodName:name
	 * @param key  
	 * @param init  初始值
	 * @return Counter
	 * @author David.Cheng
	 * @Date 2014-7-25-下午5:12:08
	 */
	public Counter counter(String key,Long init);
	
}
