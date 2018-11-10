package com.saigonbpo.dc.Service.Impl;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.wstx.util.StringUtil;
import com.saigonbpo.dc.Common.Constants;
import com.saigonbpo.dc.Mapper.AppMapper;
import com.saigonbpo.dc.Service.AppService;

@Service
@Transactional
public class AppServiceImpl implements AppService {

	@Autowired
	private AppMapper appMapper;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

}
