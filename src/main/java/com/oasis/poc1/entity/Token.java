package com.oasis.poc1.entity;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Token {

	private String token;
	private Date expires;
	private boolean ssl;
}
