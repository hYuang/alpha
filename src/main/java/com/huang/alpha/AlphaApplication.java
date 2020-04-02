package com.huang.alpha;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.container.Container;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlphaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlphaApplication.class, args);
		dubboRun();
	}


	private static  void dubboRun(){
        Container Container =   ExtensionLoader.getExtensionLoader(Container.class).getExtension("demo");
		Container.start();
    }

}

