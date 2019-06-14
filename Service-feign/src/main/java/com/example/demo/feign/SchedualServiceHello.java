package com.example.demo.feign;

import javax.websocket.server.PathParam;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.feign.feignImpl.FeignFallBack;

import config.MyConfiguration;
import feign.Param;
import feign.RequestLine;

// configuration = MyConfiguration.class,  , fallback = FeignFallBack.class
@FeignClient(value="service-hello",  fallback = FeignFallBack.class)
public interface SchedualServiceHello {
	
	/**
	   * 使用feign自带的注解@RequestLine
	   */
	//@RequestLine("GET /hello")
	//String helloFromCilent();
	
	
	/**
     * 这里需要注意的两个地方
     * <p>
     * 1、在这里使用的GetMapping注解要和被调用发一致，如果还有问题就用@RequestMapping
     * 2、@PathVariable需要设置value，如果不设置也不能成功启动
　　　*  注意点   1、路径
     * 2、Http方法必须对应
　　　* 3、使用requestBody，应该使用@PostMapping
     * 4、多个参数的时候，通过@RequestParam（"id") int id)方式调用
     */
	@RequestMapping(value="/hello",method = RequestMethod.GET)
	String helloFromCilent(@RequestParam(value = "name") String name);//

}

/*
 * 如果需要回退方法打印错误信息，可以使用fallbackFactory（fallback和fallbackFactory只能使用其中一种）
@FeignClient(name = "eureka-client-demo", fallbackFactory = ErrorFallbackFactory.class)
public interface DemoFeignClient {

    @GetMapping("/hello")
    public String hello();
}


@Component
public class ErrorFallbackFactory implements FallbackFactory<DemoFeignClient> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorFallbackFactory.class);

    @Override
    public DemoFeignClient create(Throwable throwable) {
    	System.out.println("请求错误：" + throwable.getMessage());
        return new DemoFeignClient() {
            @Override
            public String hello() {
                //如果在create()中打印错误信息的话，在应用程序启动时就会打印
                ErrorFallbackFactory.LOGGER.info("fall back cause: ", throwable);
                return "调用失败，请确定服务是否启动或稍后重试！";
            }
        };
    }
}
*/
