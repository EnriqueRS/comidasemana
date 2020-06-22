package net.dynu.dovecot.comidasemana.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Semana {
	@Id
	private int week;
	private int Monday;
	private int Tuesday;
	private int Wednesday;
	private int Thursday;
	private int Friday;
	private int Saturday;
	private int Sunday;
	
	
	public int getMonday() {
		return Monday;
	}
	public void setMonday(int monday) {
		Monday = monday;
	}
	public int getTuesday() {
		return Tuesday;
	}
	public void setTuesday(int tuesday) {
		Tuesday = tuesday;
	}
	public int getWednesday() {
		return Wednesday;
	}
	public void setWednesday(int wednesday) {
		Wednesday = wednesday;
	}
	public int getThursday() {
		return Thursday;
	}
	public void setThursday(int thursday) {
		Thursday = thursday;
	}
	public int getFriday() {
		return Friday;
	}
	public void setFriday(int friday) {
		Friday = friday;
	}
	public int getSaturday() {
		return Saturday;
	}
	public void setSaturday(int saturday) {
		Saturday = saturday;
	}
	public int getSunday() {
		return Sunday;
	}
	public void setSunday(int sunday) {
		Sunday = sunday;
	}
	
	

}
