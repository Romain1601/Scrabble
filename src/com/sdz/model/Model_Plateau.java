package com.sdz.model;

public class Model_Plateau extends Abstract_Model_Plateau  {
	
	public Model_Plateau() {
		MotTriple(matriceStatique);
		MotDouble(matriceStatique);
		LettreTriple(matriceStatique);
		LettreDouble(matriceStatique);
	}
	
	@Override
	public void MotTriple(int[][] matrice) {
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

	@Override
	public void MotDouble(int[][] matrice) {
		// TODO Auto-generated method stub
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



	@Override
	public void LettreTriple(int[][] matrice) {
		// TODO Auto-generated method stub
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



	@Override
	public void LettreDouble(int[][] matrice) {
		// TODO Auto-generated method stub
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



	@Override
	public int[][] getMatriceStatique() {
		// TODO Auto-generated method stub
		return matriceStatique;
	}
	
	@Override
	public int[][] getMatriceEtat() {
		// TODO Auto-generated method stub
		return matriceEtat;
	}




	@Override
	public String[][] getMatriceLettre() {
		// TODO Auto-generated method stub
		return  matriceLettre;
	}
	
	
	public String getMatriceLettre(int x,int y) {
		// TODO Auto-generated method stub
		return  matriceLettre[x][y];
	}



	@Override
	public void addLettrePlateau(int x, int y, String lettre) {
		if(matriceEtat[y][x]==0) {
	        matriceEtat[y][x]=1;
	        matriceLettre[y][x]=lettre;
	        notifyObserver("plateau");
		}
		
	}



	@Override
	public void selectLettrePlateau(int x, int y) {
		if(matriceEtat[y][x]==1) {
	        matriceEtat[y][x]=2;
	        notifyObserver("plateau");
		}
		
		
	}



	@Override
	public void unselectLettrePlateau(int x, int y) {
		if(matriceEtat[y][x]==2) {
	        matriceEtat[y][x]=1;
	        notifyObserver("plateau");
		}
		
	}



	@Override
	public void removeLettrePlateau(int x, int y) {
		if(matriceEtat[y][x]==1) {
	        matriceEtat[y][x]=0;
	        matriceLettre[y][x]=null;
	        notifyObserver("plateau");
		}
		
		
	}

	@Override
	public String getLettreSelect() {
		return lettreSelect;
	}

	@Override
	public void lettreSelect(String l) {
		lettreSelect=l;
		notifyObserver("plateau");
	}
	
	

	
	
	
	

}
