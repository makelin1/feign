package com.example.demo.feign.feignImpl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.feign.SchedualServiceHello;


@Service
public class FeignFallBack implements SchedualServiceHello{

	@Override
	public String helloFromCilent(String name) {
		// TODO Auto-generated method stub
		System.out.println("qqqqqqq");
		return "error";
	}

}
