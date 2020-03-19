
public class MatricePlateau {
	
	static int[][] matrice = new int[15][15];
	static int[][] matriceModify = new int[15][15];
	static String[][] matriceEtat = new String[15][15];
	static String error ="pas d'erreur";
	
	
	public MatricePlateau() {
		for(int i = 0; i < matrice.length; i++){
	        matrice[i] = new int[15];
	    }
		MotTriple();
		MotDouble();
		LettreTriple();
		LettreDouble();
	}
	
	

	public static void MotTriple() {
		for(int i = 0; i < matrice.length; i++){
            for(int j = 0; j < matrice[i].length; j++){
            	if(i==0 && j==0 || i==matrice.length-1 && j==matrice.length-1 || i==0 && j==matrice.length-1 || i==matrice.length-1 && j==0) {
            		matrice[i][j] = 9;
            	}
            	else if(i==0 && j==(matrice.length-1)/2 || i==matrice.length-1 && j==(matrice.length-1)/2) {
            		matrice[i][j] = 9;
            	}
            	else if(j==0 && i==(matrice.length-1)/2 || j==matrice.length-1 && i==(matrice.length-1)/2) {
            		matrice[i][j] = 9;
            	}
            	
            }
       }
	}
	
	public static void MotDouble() {
		for(int i = 0; i < matrice.length; i++){
            for(int j = 0; j < matrice[i].length; j++){
            	if(i==j && i>0 && i<5) {
            		matrice[i][j] = 6;
            	}
            	else if(i==j && i>8 && i<matrice.length-1) {
            		matrice[i][j] = 6;
            	}
            	else if(i>8 && i<matrice.length-1 && j==matrice.length-i-1 ) {
            		matrice[i][j] = 6;
            	}
            	else if(i>0 && i<5 && j==matrice.length-i-1 ) {
            		matrice[i][j] = 6;
            	}
            }
       }
	}
	
	public static void LettreTriple() {
		for(int i = 0; i < matrice.length; i++){
            for(int j = 0; j < matrice[i].length; j++){
            	if(i==5 && j==5 || i==9 && j==9 || i==5 && j==9 || i==9 && j==5 ) {
            		matrice[i][j] = 3;
            	}
            	else if((i==5 || i==9) && (j==1 || j==matrice.length-2)) {
            		matrice[i][j] = 3;
            	}
            	else if((j==5 || j==9) && (i==1 || i==matrice.length-2)) {
            		matrice[i][j] = 3;
            	}
            }
       }
	}
	
	
	public static void LettreDouble() {
		for(int i = 0; i < matrice.length; i++){
            for(int j = 0; j < matrice[i].length; j++){
            	if(i==6 && j==6 || i==8 && j==8 || i==6 && j==8 || i==8 && j==6 ) {
            		matrice[i][j] = 2;
            	}
            	else if((i==6 || i==8) && (j==2 || j==matrice.length-3)) {
            		matrice[i][j] = 2;
            	}
            	else if((j==6 || j==8) && (i==2 || i==matrice.length-3)) {
            		matrice[i][j] = 2;
            	}
            	else if(i==(matrice.length-1)/2 && j==3 || i==(matrice.length-1)/2 && j==matrice.length-4 ) {
            		matrice[i][j] = 2;
            	}
            	else if(j==(matrice.length-1)/2 && i==3 || j==(matrice.length-1)/2 && i==matrice.length-4 ) {
            		matrice[i][j] = 2;
            	}
            	else if(j==(matrice.length-1)/4 && i==0 || j==(matrice.length)*3/4 && i==0) {
            		matrice[i][j] = 2;
            	}
            	else if(j==(matrice.length-1)/4 && i==matrice.length-1 || j==(matrice.length)*3/4 && i==matrice.length-1) {
            		matrice[i][j] = 2;
            	}
            	
            	else if(i==(matrice.length-1)/4 && j==0 || i==(matrice.length)*3/4 && j==0) {
            		matrice[i][j] = 2;
            	}
            	else if(i==(matrice.length-1)/4 && j==matrice.length-1 || i==(matrice.length)*3/4 && j==matrice.length-1) {
            		matrice[i][j] = 2;
            	}
            }
       }
	}
	
	public static void matriceModify() {
		for(int i = 0; i < matriceModify.length; i++){
	        matriceModify[i] = new int[15];
	    }
	}
	
	public static void matriceEtat() {
		for(int i = 0; i < matriceEtat.length; i++){
	        matriceEtat[i] = new String[15];
	    }
	}
	
	
	public static int[][] GetMatrice() {
		return matrice;
	}
	
	public static int[][] GetMatriceModify() {
		return matriceModify;
	}
	
	public static String[][] GetMatriceEtat() {
		return matriceEtat;
	}
	
	
	
	public static void addlettre(int x,int y,String name) {
		if(matriceModify[y][x]==0) {
	        matriceModify[y][x]+=1;
	        matriceEtat[y][x]=name;
		}
		else {
			error = "case deja utilisé";
		}
		
        
    }
	
	public static void afficherMatriceEtat() {
		for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                System.out.print(matriceEtat[i][j] + " ");
            }
            System.out.println();
        }
	}
	
	public static void afficherMatriceModify() {
		for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                System.out.print(matriceModify[i][j] + " ");
            }
            System.out.println();
        }
	}
	
	
		
		
	
	
	public static void main(String[] args) {
		new MatricePlateau();
		
		
		for(int i = 0; i < matrice.length; i++){
            for(int j = 0; j < matrice[i].length; j++){
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();
        }
		System.out.println();
		for(int i = 0; i < matriceModify.length; i++){
            for(int j = 0; j < matriceModify[i].length; j++){
                System.out.print(matriceModify[i][j] + " ");
            }
            System.out.println();
        }
		System.out.println();
		System.out.println(error);
	}

}
