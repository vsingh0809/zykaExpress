package com.zykaExpress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto 
{
	private int menuId;
	private int userId;
	private int quantity;
}