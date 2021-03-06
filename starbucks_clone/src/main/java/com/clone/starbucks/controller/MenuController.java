package com.clone.starbucks.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clone.starbucks.DTO.CardDTO;
import com.clone.starbucks.DTO.E_couponDTO;
import com.clone.starbucks.service.MenuServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Controller
public class MenuController {
	@Autowired MenuServiceImpl service;
	
	// menu
	@RequestMapping(value = "menu/drink_list")
	public String drink_list(String CATE_CD, Model model) {
		if(CATE_CD == null) model.addAttribute("CATE_CD", "");
		else model.addAttribute("CATE_CD", CATE_CD);
		return "menu/drink_list";
	}

	@RequestMapping(value = "menu/drink_list_1")
	public String drink_list_1() {
		return "menu/drink_list-1";
	}
	@RequestMapping(value = "menu/drink_list_2")
	public String drink_list_2() {
		return "menu/drink_list-2";
	}
	@RequestMapping(value = "menu/drink_list_3")
	public String drink_list_3() {
		return "menu/drink_list-3";
	}
	@RequestMapping(value = "menu/drink_list_4")
	public String drink_list_4() {
		return "menu/drink_list-4";
	}
	@RequestMapping(value = "menu/drink_list_5")
	public String drink_list_5() {
		return "menu/drink_list-5";
	}

	@RequestMapping(value = "menu/drink_list_6")
	public String drink_list_6() {
		return "menu/drink_list-6";
	}

	@RequestMapping(value = "menu/drink_list_7")
	public String drink_list_7() {
		return "menu/drink_list-7";
	}

	@RequestMapping(value = "menu/drink_list_8")
	public String drink_list_8() {
		return "menu/drink_list-8";
	}

	@RequestMapping(value = "menu/drink_list_9")
	public String drink_list_9() {
		return "menu/drink_list-9";
	}

	@RequestMapping(value = "menu/drink_view")
	public String drink_view(String product_cd, Model model) {
		model.addAttribute("product_cd", product_cd);
		return "menu/drink_view";
	}

	@RequestMapping(value = "menu/food_list")
	public String food_list() {
		return "menu/food_list";
	}

	@RequestMapping(value = "menu/food_list_1") // ???????????? ????????? ?????? ?????? ??????????????? ?????????
	public String food_list_1(String CATE_CD) {
		return "menu/food_list-1";
	}

	@RequestMapping(value = "menu/food_list_2")
	public String food_list_2(String CATE_CD) {
		return "menu/food_list-2";
	}

	@RequestMapping(value = "menu/food_list_3")
	public String food_list_3(String CATE_CD) {
		return "menu/food_list-3";
	}

	@RequestMapping(value = "menu/food_list_4")
	public String food_list_4(String CATE_CD) {
		return "menu/food_list-4";
	}

	@RequestMapping(value = "menu/food_list_5")
	public String food_list_5(String CATE_CD) {
		return "menu/food_list-5";
	}

	@RequestMapping(value = "menu/food_list_6")
	public String food_list_6(String CATE_CD) {
		return "menu/food_list-6";
	}

	@RequestMapping(value = "menu/food_list_7")
	public String food_list_7(String CATE_CD) {
		return "menu/food_list-7";
	}

	@RequestMapping(value = "menu/food_view")
	public String food_view(String product_cd, Model model) {
		model.addAttribute("product_cd", product_cd);
		return "menu/food_view";
	}

	@RequestMapping(value = "menu/product_list")
	public String product_list() {
		return "menu/product_list";
	}

	@RequestMapping(value = "menu/product_list_1")
	public String product_list_1() {
		return "menu/product_list-1";
	}

	@RequestMapping(value = "menu/product_list_2")
	public String product_list_2() {
		return "menu/product_list-2";
	}

	@RequestMapping(value = "menu/product_list_3")
	public String product_list_3() {
		return "menu/product_list-3";
	}

	@RequestMapping(value = "menu/product_list_4")
	public String product_list_4() {
		return "menu/product_list-4";
	}

	@RequestMapping(value = "menu/product_list_5")
	public String product_list_5() {
		return "menu/product_list-5";
	}

	@RequestMapping(value = "menu/product_list_6")
	public String product_list_6() {
		return "menu/product_list-6";
	}

	@RequestMapping(value = "menu/product_list_7")
	public String product_list_7() {
		return "menu/product_list-7";
	}

	@RequestMapping(value = "menu/product_list_8")
	public String product_list_8() {
		return "menu/product_list-8";
	}

	@RequestMapping(value = "menu/product_list_9")
	public String product_list_9() {
		return "menu/product_list-9";
	}

	@RequestMapping(value = "menu/product_view")
	public String product_view(String product_cd, Model model) {
		model.addAttribute("product_cd", product_cd);
		return "menu/product_view";
	}
	
	//sale
	@RequestMapping(value = "menu/orderList")//??? ????????? ????????? ??????
	public String orderList() {
		service.resetOrderList();
		return "menu/orderList";
	}

	@RequestMapping(value = "menu/myOrder")
	public String menu_myOrder() {
		
		return "menu/myOrder";
	}

	
	@RequestMapping(value="menu/couponUse")
	public String couponUse(E_couponDTO eCouponDTO, Model model) throws ParseException  {
		service.couponUse(eCouponDTO, model);
		return "menu/coupon_popup";
	}
	
	@RequestMapping(value="menu/cardChoice")
	public String cardChoice(CardDTO cardDTO, Model model) {
		service.cardChoice(cardDTO, model);
		return "menu/starbucksCard";
	}

	
	// ajax
	@ResponseBody // ??????list-??????
	@PostMapping(value = "upload/json/menu/{path}", produces = "application/json; charset=UTF-8")
	public String ajaxJson(@PathVariable String path) throws FileNotFoundException, IOException {
		String mappingPath = "upload/json/menu/" + path + ".json";
		ClassPathResource resource = new ClassPathResource(mappingPath);
		FileReader reader = new FileReader(resource.getFile());
		Gson gson = new Gson();
		JsonObject obj = gson.fromJson(reader, JsonObject.class);
		return obj.toString();
	}

	@ResponseBody // ????????????-??????
	@PostMapping(value = "menu/productViewAjax", produces = "application/json; charset=UTF-8")
	public String productViewAjax(HttpServletRequest request) throws FileNotFoundException, IOException {
		String product_cd = request.getParameter("product_cd");
		String product_cate = request.getParameter("product_cate");
		String mappingPath = "";
		if (product_cate.equals("drink"))
			mappingPath = "upload/json/menu/detail/info_drink.json";
		else if (product_cate.equals("food"))
			mappingPath = "upload/json/menu/detail/info_food.json";
		else if (product_cate.equals("product"))
			mappingPath = "upload/json/menu/detail/info_product.json";

		ClassPathResource resource = new ClassPathResource(mappingPath);
		FileReader reader = new FileReader(resource.getFile());
		Gson gson = new Gson();
		JsonObject obj = gson.fromJson(reader, JsonObject.class);
		JsonObject result = new JsonObject();
		JsonElement cd = obj.get(product_cd);
		result.add("view", cd);
		return result.toString();
	}

	@ResponseBody // ???????????????-??????
	@PostMapping(value = "menu/productFileAjax", produces = "application/json; charset=UTF-8")
	public String productFileAjax(HttpServletRequest request) throws FileNotFoundException, IOException {
		String product_cd = request.getParameter("product_cd");
		String product_cate = request.getParameter("product_cate");
		String mappingPath = "";
		if (product_cate.equals("drink"))
			mappingPath = "upload/json/menu/detail/file_drink.json";
		else if (product_cate.equals("food"))
			mappingPath = "upload/json/menu/detail/file_food.json";
		else if (product_cate.equals("product"))
			mappingPath = "upload/json/menu/detail/file_product.json";

		ClassPathResource resource = new ClassPathResource(mappingPath);
		FileReader reader = new FileReader(resource.getFile());
		Gson gson = new Gson();
		JsonObject obj = gson.fromJson(reader, JsonObject.class);
		JsonObject result = new JsonObject();
		JsonElement cd = obj.get(product_cd);
		result.add("file", cd);
		if (product_cate.equals("product"))
			return result.toString();
		StringBuffer strbuffer = new StringBuffer(result.toString());
		strbuffer.insert(8, "[");
		strbuffer.insert(strbuffer.length() - 1, "]");
		return strbuffer.toString();
	}
	
	@ResponseBody // ????????? ?????? ????????????-??????
	@PostMapping(value = "menu/getMsrXoCategoryList", produces = "application/json; charset=UTF-8")
	public String getMsrXoCategoryList(HttpServletRequest request) throws FileNotFoundException, IOException {
		String mappingPath = "upload/json/menu/custom/category.json";
		ClassPathResource resource = new ClassPathResource(mappingPath);
		FileReader reader = new FileReader(resource.getFile());
		Gson gson = new Gson();
		JsonObject obj = gson.fromJson(reader, JsonObject.class);
		return obj.toString();
	}
	
	@ResponseBody // ????????? ?????? ??????-??????
	@PostMapping(value = "menu/getMsrXoSkuList", produces = "application/json; charset=UTF-8")
	public String getMsrXoSkuList(HttpServletRequest request) throws FileNotFoundException, IOException {
		String gbn = request.getParameter("gbn");
		String mappingPath = "";
		if(gbn.equals("A")) {
			mappingPath = "upload/json/menu/custom/all.json";
		}else {
			String categoryCode = request.getParameter("categoryCode");
			//
			mappingPath = "upload/json/menu/custom/" + categoryCode + ".json";
		}
		ClassPathResource resource = new ClassPathResource(mappingPath);
		FileReader reader = new FileReader(resource.getFile());
		Gson gson = new Gson();
		JsonObject obj = gson.fromJson(reader, JsonObject.class);
		return obj.toString();
	}
	
	@ResponseBody // ????????? ?????? ????????? ????????????-??????
	@PostMapping(value = "menu/getMsrXoCustomCategoryList", produces = "application/json; charset=UTF-8")
	public String getMsrXoCustomCategoryList(HttpServletRequest request) throws FileNotFoundException, IOException {
		String product_cd = request.getParameter("skuNo");
		String mappingPath = "upload/json/menu/custom/customCategoryList.json";
		ClassPathResource resource = new ClassPathResource(mappingPath);
		FileReader reader = new FileReader(resource.getFile());
		Gson gson = new Gson();
		JsonObject obj = gson.fromJson(reader, JsonObject.class);
		JsonElement data = obj.get(product_cd);
		JsonObject result = new JsonObject();
		result.addProperty("result_code", "SUCCESS");
		result.add("data", data);
		return result.toString();
	}
	
	@ResponseBody // ????????? ?????? ????????? ????????????-??????
	@PostMapping(value = "menu/getMsrXoCustomSkuList", produces = "application/json; charset=UTF-8")
	public String getMsrXoCustomSkuList(HttpServletRequest request) throws FileNotFoundException, IOException {
//		categoryCode: ???C0000012 , ?????????C0000141, ?????????C0000169
		String categoryCode = request.getParameter("categoryCode");
		String mappingPath = "upload/json/menu/custom/detail/" + categoryCode + ".json";
		ClassPathResource resource = new ClassPathResource(mappingPath);
		FileReader reader = new FileReader(resource.getFile());
		Gson gson = new Gson();
		JsonObject obj = gson.fromJson(reader, JsonObject.class);
		return obj.toString();
	}
	
	@ResponseBody // ????????? ?????? ????????????-??????
	@PostMapping(value = "menu/setMsrXoMyMenuRegister")
	public String setMsrXoMyMenuRegister(@RequestBody HashMap<String,String> data){
//		"delegateSku"     : delegateSku
//		,"nickname"        : repalceAnd(nickname)
//		,"p_name"		   : p_name
//		,"customFlag"      : customFlag
//		,"cupType"         : cupType
//		,"customList"      : customList
		if(data != null) {
			if(service.setMyMenu(data)) return "SUCCESS";
		}
		return "FAIL";
	}
	
	
	//sale??????
	@ResponseBody // ???????????? ?????????-??????
	@PostMapping(value = "menu/setOrderAjax")
	public String setOrderAjax(@RequestBody HashMap<String,String> data){
		if(data != null) {
			if(service.setOrderList(data)) return "SUCCESS";
		}
		return "FAIL";
	}
	
	@ResponseBody // ???????????? ??? ??????-??????
	@PostMapping(value = "menu/setOrderCountAjax")
	public String setOrderCountAjax(@RequestBody HashMap<String,String> data){
		System.out.println("?????????" + data);
		if(data != null) {
			if(service.setOrderCount(data)) return "SUCCESS";
		}
		return "FAIL";
	}
	
	@RequestMapping(value = "menu/payment")
	@ResponseBody // ???????????? - ??????
	public int payment(@RequestBody HashMap<String,String> data) throws ParseException {
		System.out.println(data);
		String date = data.get("pay_date");
		date = date.substring(0, 19).replace("T", " ");
		data.put("pay_date", date);
		
		int res = service.payment(data);
		if(res == 1) {
			System.out.println("????????? ?????? ??????");
		}
		//????????? 1??????
		return res;
	}
	
/*	
	//DB??? ?????? json????????????
	@RequestMapping("menu/makeDrinkMenu")
	public String makeDrinkMenu() throws FileNotFoundException, IOException {
		//20new 25????????? 26??????????????? 27??? 31??????????????? 34?????????????????? 37???????????? 39????????? 41???????????? 
		//42?????? 46???????????? 56???????????? 65??????????????? 66???????????????
		String fileName[] = { "25", "26", "27", "31", "34", "37", "39", "41", "46", "56", "65", "66"};
		JsonArray drinkfile = new JsonArray();//????????? ?????? json ??????
		for(String file : fileName) {
			String category = "";
			switch(file) {
			case "25": category = "?????????"; break;
			case "26": category = "???????????????"; break;
			case "27": category = "???"; break;
			case "31": category = "???????????????"; break;
			case "34": category = "??????????????????"; break;
			case "37": category = "????????????"; break;
			case "39": category = "?????????"; break;
			case "41": category = "????????????"; break;
			case "46": category = "????????????"; break;
			case "56": category = "????????????"; break;
			case "65": category = "???????????????"; break;
			case "66": category = "???????????????"; break;
			}
			String mappingPath = "upload/json/menu/custom/makefile/" + file + ".json";
			ClassPathResource resource = new ClassPathResource(mappingPath);
			FileReader reader = new FileReader(resource.getFile());
			Gson gson = new Gson();
			JsonObject obj = gson.fromJson(reader, JsonObject.class);
			JsonArray list = obj.get("menuList").getAsJsonArray();
			System.out.println("@??????????????? ??????@");
			for(JsonElement tmp : list) {
				JsonObject aa = tmp.getAsJsonObject();
				JsonArray jarr = aa.get("hotSku").getAsJsonObject().get("hotSkuList").getAsJsonArray();
				if(jarr.isEmpty()) {
					jarr = aa.get("icedSku").getAsJsonObject().get("icedSkuList").getAsJsonArray();
				}
				String price = jarr.get(0).getAsJsonObject().get("price").getAsString();
				System.out.print("???????????? : " + price);
				String name = aa.get("delegateSku").getAsJsonObject().get("skuName").getAsString();
				System.out.println(" ?????? : " + name);
				
				//json?????? ?????????
				JsonObject drinkentry = new JsonObject();
				drinkentry.addProperty("p_category1", "??????");
				drinkentry.addProperty("p_category2", category);
				drinkentry.addProperty("p_name", name);
				drinkentry.addProperty("p_price", price);
				drinkfile.add(drinkentry);
			}
		}
		
		String filepathName = "C:\\Users\\gmg_2\\Desktop\\drink.json" ;
		try{
			// BufferedWriter ??? FileWriter??? ???????????? ?????? (?????? ??????)
			BufferedWriter fw = new BufferedWriter(new FileWriter(filepathName, true));
			// ???????????? ????????? ??????
			fw.write(drinkfile.toString());
			fw.flush();
			// ?????? ??????
			fw.close(); 
		}catch(Exception e){
			e.printStackTrace();
		}
		return "index";
	}
*/	
	
	//DB??? ??? ?????? ?????? **??? ????????? ??????** ??????
	@RequestMapping("init/initDrink")
	public String initDrink() throws FileNotFoundException, IOException{
		service.insertMenu("drink");
		return "index";
	}
	
	@RequestMapping("init/initFood")
	public String initFood() throws FileNotFoundException, IOException{
		service.insertMenu("food");
		return "index";
	}
	
	@RequestMapping("init/initEtc")
	public String initEtc() throws FileNotFoundException, IOException{
		service.insertMenu("etc");
		return "index";
	}
	
}
