package config;

import java.beans.Encoder;

import org.apache.http.conn.ConnectTimeoutException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

import feign.Contract;
import feign.Logger;
import feign.Request;
import feign.Retryer;
import feign.codec.Decoder;

@Configuration
public class MyConfiguration {
	/**
	   * 将契约改为feign原生的默认契约。这样就可以使用feign自带的注解了。
	   * @return 默认的feign契约
	   */
	@Bean
	public Encoder feignEncoder() {return new Encoder();}
	
 
	@Bean
	public Decoder feignDecoder() {return null; }
	
//	  @Bean 
//	  public Contract feignContract() { 
//		  return new Contract.Default(); 
//	  }
	  
	/* 修改日志级别 */
	  //@Bean
	  //public Logger.Level feignLoggerLevel() {
	//	  return Logger.Level.BASIC;
	  //}
	 
	/* 配置重试  此处配置不进行重试*/
	  @Bean
	  public Retryer feignRe() {
		  //return new Request.Options(ConnectTimeoutMillis, readTimeoutMillis)
		  return new Retryer.Default();
	  }
	  
	  /* 配置请求的连接和处理超时时间 */
	  @Bean
	  public Request.Options feignRequsetOptions() {
		  //return new Request.Options(ConnectTimeoutMillis, readTimeoutMillis)
		  return new Request.Options(10000,60000);
	  }
	
//	  @Bean 
//	  public IRule ribbonRule(IClientConfig config) { 
//		  // 负载均衡规则，改为随机 
//		  return new RandomRule(); 
//	  }
	 
}