package com.portfolio.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portfolio.domain.HostVo;
import com.portfolio.domain.LocationVo;
import com.portfolio.domain.ReviewVo;
import com.portfolio.mapper.HostMapper;
import com.portfolio.mapper.LocationMapper;
import com.portfolio.mapper.ReviewMapper;

@Service
public class LocationService {
	
	@Autowired
	private LocationMapper locationMapper;
	
	@Autowired
	private ReviewMapper reviewMapper;
	
	@Autowired
	private HostMapper hostMapper;
	
	
	@Transactional
	public Map<String, Object> getLocationListAndMainInfo() {

		List<LocationVo> locationList = locationMapper.getLocationList();
		List<ReviewVo> reviewList = reviewMapper.getReviews();
		List<HostVo> hostList = new ArrayList<HostVo>();
		hostList.add(hostMapper.getContentInfoForMain("아파트"));
		hostList.add(hostMapper.getContentInfoForMain("주택"));
		hostList.add(hostMapper.getContentInfoForMain("독특한 숙소"));
		hostList.add(hostMapper.getContentInfoForMain("부티크 호텔"));
		
		Map<String, Object> obj = new HashMap<>();
		obj.put("locationList", locationList);
		obj.put("reviewList", reviewList);
		obj.put("hostList", hostList);
		return obj;
	}
}
