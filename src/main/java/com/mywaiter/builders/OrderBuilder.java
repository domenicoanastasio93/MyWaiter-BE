package com.mywaiter.builders;

import org.springframework.stereotype.Service;

import com.mywaiter.dto.OrderDTO;
import com.mywaiter.models.Order;

@Service
public class OrderBuilder {

	public OrderDTO buildOrderDTO(Order o) {
		if (o == null) {
			return null;
		}

		OrderDTO ret = new OrderDTO();
		ret.setId(o.getId());
		ret.setTable(o.getTable());

		// TODO json

		ret.setAdditiveNotes(o.getAdditiveNotes());
		ret.setCreationDate(o.getCreationDate());
		ret.setUpdateDate(o.getUpdateDate());
		return ret;
	}

}
