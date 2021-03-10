package com.mywaiter.schedulers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.mywaiter.models.Category;
import com.mywaiter.models.Dish;
import com.mywaiter.repositories.CategoryRepository;
import com.mywaiter.repositories.DishRepository;

@Component
public class InitService implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private DishRepository dishRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		this.initCategoriesAndDishes();
	}

	public void initCategoriesAndDishes() {
		long count = categoryRepository.count();
		if (count > 0) {
			return;
		}

		this.initCategory1();
		this.initCategory2();
		this.initCategory3();
		this.initCategory4();
		this.initCategory5();
		this.initCategory6();
	}

	private void initCategory1() {
		Category c = new Category();
		c.setNameEn("First courses of pasta");
		c.setNameIt("Primi piatti di pasta");
		c.setOrder(1);
		c.setAdditiveNotesEn("These are additive notes for the first courses of pasta");
		c.setAdditiveNotesIt("Queste sono note aggiuntive per i primi di pasta");
		c = categoryRepository.saveAndFlush(c);
		Dish d1 = new Dish();
		d1.setCategory(c);
		d1.setName("Spaghetti al pomodoro");
		d1.setOrder(1);
		d1.setDescriptionEn("Ingredients: Spaghetti, tomatoes and basil");
		d1.setDescriptionIt("Ingredienti: Spaghetti, pomodoro e basilico");
		d1.setPrice(3.5f);
		dishRepository.saveAndFlush(d1);
		Dish d2 = new Dish();
		d2.setCategory(c);
		d2.setName("Spaghetti alle vongole");
		d2.setOrder(2);
		d2.setDescriptionEn("Ingredients: Spaghetti, clams and parsley");
		d2.setDescriptionIt("Ingredienti: Spaghetti, vongole e prezzemolo");
		d2.setPrice(5f);
		dishRepository.saveAndFlush(d2);
	}

	private void initCategory2() {
		Category c = new Category();
		c.setNameEn("Second courses of meat");
		c.setNameIt("Secondi piatti di carne");
		c.setOrder(2);
		c.setAdditiveNotesEn("These are additive notes for the second courses of meat");
		c.setAdditiveNotesIt("Queste sono note aggiuntive per i secondi di carne");
		c = categoryRepository.saveAndFlush(c);
		Dish d1 = new Dish();
		d1.setCategory(c);
		d1.setName("Costine di maiale");
		d1.setOrder(1);
		d1.setDescriptionEn("Ingredients: Racks");
		d1.setDescriptionIt("Ingredienti: Costine");
		d1.setPrice(5.5f);
		dishRepository.saveAndFlush(d1);
		Dish d2 = new Dish();
		d2.setCategory(c);
		d2.setName("Straccetti di vitello");
		d2.setOrder(2);
		d2.setDescriptionEn("Ingredients: Veal, rocket and parmesan");
		d2.setDescriptionIt("Ingredienti: Vitello, rucola e grana");
		d2.setPrice(7f);
		dishRepository.saveAndFlush(d2);
	}

	private void initCategory3() {
		Category c = new Category();
		c.setNameEn("Second courses of fish");
		c.setNameIt("Secondi piatti di pesce");
		c.setOrder(3);
		c.setAdditiveNotesEn("These are additive notes for the second courses of fish");
		c.setAdditiveNotesIt("Queste sono note aggiuntive per i secondi di pesce");
		c = categoryRepository.saveAndFlush(c);
		Dish d1 = new Dish();
		d1.setCategory(c);
		d1.setName("Frittura mista");
		d1.setOrder(1);
		d1.setDescriptionEn("Ingredients: Shrimps, squids and lemon");
		d1.setDescriptionIt("Ingredienti: Gamberi, calamari e limone");
		d1.setPrice(9f);
		dishRepository.saveAndFlush(d1);
		Dish d2 = new Dish();
		d2.setCategory(c);
		d2.setName("Pesce spada alla griglia");
		d2.setOrder(2);
		d2.setDescriptionEn("Ingredients: Swordfish");
		d2.setDescriptionIt("Ingredienti: Pesce spada");
		d2.setPrice(13f);
		dishRepository.saveAndFlush(d2);
	}

	private void initCategory4() {
		Category c = new Category();
		c.setNameEn("Side dishes");
		c.setNameIt("Contorni");
		c.setOrder(4);
		c.setAdditiveNotesEn("These are additive notes for the side dishes");
		c.setAdditiveNotesIt("Queste sono note aggiuntive per i contorni");
		c = categoryRepository.saveAndFlush(c);
		Dish d1 = new Dish();
		d1.setCategory(c);
		d1.setName("Insalata");
		d1.setOrder(1);
		d1.setDescriptionEn("Ingredients: Salad");
		d1.setDescriptionIt("Ingredienti: Insalata");
		d1.setPrice(2f);
		dishRepository.saveAndFlush(d1);
		Dish d2 = new Dish();
		d2.setCategory(c);
		d2.setName("Patatine fritte");
		d2.setOrder(2);
		d2.setDescriptionEn("Ingredients: Chips");
		d2.setDescriptionIt("Ingredienti: Patatine");
		d2.setPrice(1.5f);
		dishRepository.saveAndFlush(d2);
	}

	private void initCategory5() {
		Category c = new Category();
		c.setNameEn("Red wines");
		c.setNameIt("Vini rossi");
		c.setOrder(5);
		c.setAdditiveNotesEn("These are additive notes for the red wines");
		c.setAdditiveNotesIt("Queste sono note aggiuntive per i vini rossi");
		c = categoryRepository.saveAndFlush(c);
		Dish d1 = new Dish();
		d1.setCategory(c);
		d1.setName("Aglianico");
		d1.setOrder(1);
		d1.setDescriptionEn("Red wine Aglianico");
		d1.setDescriptionIt("Vino rosso Aglianico");
		d1.setPrice(15f);
		dishRepository.saveAndFlush(d1);
		Dish d2 = new Dish();
		d2.setCategory(c);
		d2.setName("Taurasi");
		d2.setOrder(2);
		d2.setDescriptionEn("Red wine Taurasi");
		d2.setDescriptionIt("Vino rosso Taurasi");
		d2.setPrice(12f);
		dishRepository.saveAndFlush(d2);
	}

	private void initCategory6() {
		Category c = new Category();
		c.setNameEn("White wines");
		c.setNameIt("Vini bianchi");
		c.setOrder(6);
		c.setAdditiveNotesEn("These are additive notes for the white wines");
		c.setAdditiveNotesIt("Queste sono note aggiuntive per i vini bianchi");
		c = categoryRepository.saveAndFlush(c);
		Dish d1 = new Dish();
		d1.setCategory(c);
		d1.setName("Falanghina");
		d1.setOrder(1);
		d1.setDescriptionEn("White wine Falanghina");
		d1.setDescriptionIt("Vino bianco Falanghina");
		d1.setPrice(13f);
		dishRepository.saveAndFlush(d1);
		Dish d2 = new Dish();
		d2.setCategory(c);
		d2.setName("Pinot");
		d2.setOrder(2);
		d2.setDescriptionEn("White wine Pinot");
		d2.setDescriptionIt("White wine Pinot");
		d2.setPrice(18f);
		dishRepository.saveAndFlush(d2);
	}

}
