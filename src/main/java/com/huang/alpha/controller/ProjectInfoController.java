package com.huang.alpha.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.huang.alpha.constants.Constants;
import com.huang.alpha.enums.Result;
import com.huang.alpha.model.Response;
import com.huang.alpha.util.FileUtil;


@RestController
@RequestMapping("/info")
public class ProjectInfoController {
	private final String  info = "info.json";
	
	@RequestMapping(value="/project"  , method= {RequestMethod.POST})
	@ResponseBody
	public Response getProjectInfo() {
		Response response = new Response();
		try {
			String fileInfo = FileUtil.getFileContent(info,Constants.CHARSET_UTF_8);
			JSON data = JSON.parseObject(fileInfo);
			response.setData(data);
			response.setMsg(Result.SUCCESS.getValue());
			response.setMsg_code(Result.SUCCESS_CODE.getValue());
		} catch (IOException e) {
			e.printStackTrace();
			response.setData(null);
			response.setMsg(Result.FAIL.getValue());
			response.setMsg_code(Result.FAIL_CODE.getValue());
		}
		return response;
		
	}
}
