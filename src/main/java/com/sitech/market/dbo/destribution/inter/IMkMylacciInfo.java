package com.sitech.market.dbo.destribution.inter;


import java.util.Map;


public interface IMkMylacciInfo {

	public boolean add(Map<String,Object> mkMylacciInfo);
	public boolean deleteById(String id);
	
}
