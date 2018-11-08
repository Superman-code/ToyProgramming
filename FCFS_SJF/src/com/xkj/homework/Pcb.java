package com.xkj.homework;

public class Pcb {
	private double arrivalTime; // 到达时间
	private double serviceTime; // 服务时间

	private double finishTime; // 完成时间
	private double turnOverTime; // 周转时间
	private double weightedTurnOverTime; // 带权周转时间

	public Pcb() {
		super();
	}

	public double getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(double arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public double getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(double serviceTime) {
		this.serviceTime = serviceTime;
	}

	public double getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(double finishTime) {
		this.finishTime = finishTime;
	}

	public double getTurnOverTime() {
		return turnOverTime;
	}

	public void setTurnOverTime(double turnOverTime) {
		this.turnOverTime = turnOverTime;
	}

	public double getWeightedTurnOverTime() {
		return weightedTurnOverTime;
	}

	public void setWeightedTurnOverTime(double weightedTurnOverTime) {
		this.weightedTurnOverTime = weightedTurnOverTime;
	}

}
