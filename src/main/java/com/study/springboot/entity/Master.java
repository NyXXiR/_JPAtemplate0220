package com.study.springboot.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude ="slaveList") //slaveList가 빈방인채로 있으므로 제외시킨다 exclude

public class Master {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long mid;
	private String code;
	private String comment;
	
	//FetchType , CascadeType Enum type이다
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "master", 
				cascade =CascadeType.ALL)
	//mappedBy하게되면 slaveList테이블이 생성되지않고 master테이블에 맵핑된다
	
	private List<Slave>slaveList = new ArrayList <>();
	//builder 패턴으로는 컬렉션객체 생성이 안된다.
	
	public void addSlave(Slave slave) {
		slave.setIdx(this.slaveList.size());
		slave.setMaster(this);
		slaveList.add(slave);
	}
	
	
}	
