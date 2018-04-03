package com.tydic.study.rpc.util;

public class CountServiceImpl implements CountService {
	private int count = 0;

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return count++;
	}

}
