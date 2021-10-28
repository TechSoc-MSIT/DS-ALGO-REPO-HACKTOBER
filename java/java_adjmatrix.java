class GraphAdjMatrix{
	private boolean adjMatrix[][];
	private int vertexCount;
	public GraphAdjMatrix(int vertexCount)
	{
		this.vertexCount=vertexCount;
		adjMatrix= new boolean[vertexCount][vertexCount];
		for(int i=0;i<vertexCount;i++)
		{
			for(int j=0;j<vertexCount;j++)
			{
			adjMatrix[i][j]=false;
		}
		}
	}

	public void addEdge(int i, int j)
	{
		if(i>=0 && i < vertexCount && j >=0 && j<vertexCount)
		{
			adjMatrix[i][j]=true;
			adjMatrix[j][i]=true;
		}

	}

	public void removeEdge(int i, int j)
	{
		if(i>=0 && i < vertexCount && j >=0 && j<vertexCount)
		{
			adjMatrix[i][j]=false;
			adjMatrix[j][i]=false;
		}

	}
	public boolean isEdge(int i, int j)
	{
		if(i>=0 && i < vertexCount && j >=0 && j<vertexCount)
		{
			return adjMatrix[i][j];
		}
		else
			return false;
	}
	public static void main(String[] args) {

	GraphAdjMatrix graph = new GraphAdjMatrix(4);
	graph.addEdge(0,0);
	graph.addEdge(1,2);
	graph.addEdge(2,3);
	graph.addEdge(3,1);
	printGraph(graph,4);
  }

		static void printGraph(GraphAdjMatrix graph , int vertex)
		{
				for(int i=0;i<vertex;i++)
				{
					for(int j=0;j<vertex;j++)
					{
						System.out.print(" "+(graph.isEdge(i,j)?1:0)+"");
					}
					System.out.println();
				}
		}

}
