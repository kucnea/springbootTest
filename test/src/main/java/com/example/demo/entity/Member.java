package com.example.demo.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="MEMBER")
@ToString
@SequenceGenerator(
		name="MEMBER_SEQ_GENERATOR",
		sequenceName="MEMBER_SEQ",
		initialValue=1, allocationSize=1
	)
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
	private int MIdx;
	
	@Column(nullable = false, length = 16)
	private String MId;
	
	@Column(nullable = false, length = 16)
	private String MPw;
	
	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
	private Set<Board> board;
	
}
