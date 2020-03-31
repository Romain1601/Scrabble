
import com.sdz.model.Model_Pioche;
import com.sdz.vue.Vue;


public class Main {
	
	static Model_Pioche modelPioche = new Model_Pioche(); 

	
	public static void main(String[] args) {
		Vue vue = new Vue(modelPioche);
		vue.getVue();

	}

}
