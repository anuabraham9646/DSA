package graph;

public class ApplicationMaze {

	public static void main(String[] args) {
		FileParserMaze fm = new FileParserMaze("F:\\eclipse program\\FunProgramming\\src\\graph\\maze.txt", 5, 5);
		fm.parseFile();
		
		Maze m = new Maze(fm.getMap(), fm.getStartRow(), fm.getStartCol());
		m.findWay();

	}

}
