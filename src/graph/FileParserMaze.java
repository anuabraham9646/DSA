package graph;

import java.io.File;
import java.util.Scanner;

public class FileParserMaze {
	
	private String fileName;
	private int map[][];
	private int startRow;
	private int startCol;
	private int numRow,numCol;
	
	
	public FileParserMaze(String fileName, int numRow, int numCol) {
		super();
		this.fileName = fileName;
		this.map = new int [numRow][numCol];
		this.numRow = numRow;
		this.numCol = numCol;
	}
	
	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getStartCol() {
		return startCol;
	}

	public void setStartCol(int startCol) {
		this.startCol = startCol;
	}

	public void parseFile() {
		try {
			
			Scanner sc= new Scanner(new File(this.fileName));
			for(int i=0;i<numRow;i++) {
				for(int j=0;j<numCol;j++) {
					map[i][j]= sc.nextInt();
					
					if(map[i][j]==2) {
						startRow=i;
						startCol=j;
					}
				}
			}
			sc.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int[][] getMap() {
		return map;
	}


}
