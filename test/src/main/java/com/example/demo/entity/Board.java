package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name="BOARD")
@ToString
@SequenceGenerator(
		name="BOARD_SEQ_GENERATOR",
		sequenceName="BOARD_SEQ",
		initialValue=1, allocationSize=1
	)
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ_GENERATOR")
	private int BIdx;
	
	@Column(nullable = false, length = 16)
	private String BTitle;
	
	@Lob
	@Column(nullable = false, length = 16)
	private String BContent;
	
	@ManyToOne
	@JoinColumn(name="MIdx", referencedColumnName = "MIdx")
	private Member member;
	
}
