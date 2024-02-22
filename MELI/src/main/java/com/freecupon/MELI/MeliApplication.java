package com.freecupon.MELI;

import com.freecupon.MELI.helpers.uitls.TotalCalculations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class MeliApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeliApplication.class, args);

		List<Integer> prices = new ArrayList<>();
		prices.add(100);
		prices.add(210);
		prices.add(260);
		prices.add(80);
		prices.add(90);

		Map<String, Integer> items = new HashMap<>();
		items.put("MLA1",100);
		items.put("MLA2",210);
		items.put("MLA3",260);
		items.put("MLA4",80);
		items.put("MLA5",90);

		Integer cuponValue = 500;
		Integer qOfElements = prices.size();

		TotalCalculations total = new TotalCalculations();
		int total_2 = total.total(qOfElements,cuponValue,prices);
		System.out.println(total_2);
	}
}
