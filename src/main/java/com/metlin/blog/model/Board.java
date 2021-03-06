package com.metlin.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OrderBy;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length=100)
	private String title;
	
	@Lob
	private String content;
	
	@ColumnDefault("0")
	private int count;
	
	@CreationTimestamp
	private Timestamp regDt;
	
	private Timestamp updateDt;
	
	@ManyToOne(fetch = FetchType.EAGER)  //many=Board, one=BlogUser
	@JoinColumn(name = "user_id")
	private BlogUser user;
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE) // mappedBy 연관관계의 주인이 아니다. (난 FK가 아니다.)
	@JsonIgnoreProperties({"board"})
	@OrderBy(clause = "id desc")
	private List<Reply> replys;
}
