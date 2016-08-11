package com.qian;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class BFS {
	private static final int MAXPATH = Integer.MAX_VALUE;
	// 邻接矩阵存储图
    // --A B C D E F G H I
    // A 0 1 0 0 0 1 1 0 0
    // B 1 0 1 0 0 0 1 0 1
    // C 0 1 0 1 0 0 0 0 1
    // D 0 0 1 0 1 0 1 1 1
    // E 0 0 0 1 0 1 0 1 0
    // F 1 0 0 0 1 0 1 0 0
    // G 0 1 0 1 0 1 0 1 0
    // H 0 0 0 1 1 0 1 0 0
    // I 0 1 1 1 0 0 0 0 0
 
    // 顶点数
    private int number = 9;
    // 记录顶点是否被访问
    private boolean[] flag;
    // 顶点
    private String[] vertexs = { "A", "B", "C", "D", "E", "F", "G", "H", "I" };
    // 边
    private int[][] edges = {
            { 0, 1, 0, 0, 0, 1, 1, 0, 0 }, { 1, 0, 1, 0, 0, 0, 1, 0, 1 }, { 0, 1, 0, 1, 0, 0, 0, 0, 1 },
            { 0, 0, 1, 0, 1, 0, 1, 1, 1 }, { 0, 0, 0, 1, 0, 1, 0, 1, 0 }, { 1, 0, 0, 0, 1, 0, 1, 0, 0 },
            { 0, 1, 0, 1, 0, 1, 0, 1, 0 }, { 0, 0, 0, 1, 1, 0, 1, 0, 0 }, { 0, 1, 1, 1, 0, 0, 0, 0, 0 }
            };
 
    // 图的深度遍历操作(递归)
    void DFSTraverse() {
        flag = new boolean[number];
        for (int i = 0; i < number; i++) {
            if (flag[i] == false) {// 当前顶点没有被访问
                DFS(i);
            }
        }
    }
 
    // 图的深度优先递归算法
    void DFS(int i) {
        flag[i] = true;// 第i个顶点被访问
        System.out.print(vertexs[i] + " ");
        for (int j = 0; j < number; j++) {
            if (flag[j] == false && edges[i][j] == 1) {
                DFS(j);
            }
        }
    }
 
    // 图的广度遍历操作
    void BFSTraverse() {
        flag = new boolean[number];
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < number; i++) {
            if (flag[i] == false) {
                flag[i] = true;
                System.out.print(vertexs[i] + " ");
                queue.add(i);
                while (!queue.isEmpty()) {
                    int j = queue.poll();
                    for (int k = 0; k < number; k++) {
                        if (edges[j][k] == 1 && flag[k] == false) {
                            flag[k] = true;
                            System.out.print(vertexs[k] + " ");
                            queue.add(k);
                        }
                    }
                }
            }
        }
    }
 
    // 测试
    public static void main(String[] args) {
    	BFS graph = new BFS();
        System.out.println("图的深度遍历操作(递归):");
        graph.DFSTraverse();
        System.out.println("\n-------------");
        System.out.println("图的广度遍历操作:");
        graph.BFSTraverse();
    }
	
	public int dijkstra(int startIndex, int endIndex, List<Integer> pathVertexs)
	{
		ArrayList<Integer> vertexList = new ArrayList<>();
		vertexList.add(startIndex);
	//	Path path = new Path();
		/*for (int i = 0; i < otherV.size(); i++) {
			if (!vertexs[otherV.get(i)].isVisited()) {
				vertexList.add(otherV.get(i));
			}
		}*/
		//添加所有点
		vertexList.add(endIndex);
		
		/*System.out.println(vertexList);*/
		
		boolean[] hasVisited = new boolean[vertexList.size()];
		
		//构建prev[]数组，保存该点对应的先前节点
		int[] prev = new int[vertexList.size()];
		
		int[] dist = new int[vertexList.size()];
		for (int i = 0; i < dist.length; i++) {
			dist[i] = edges[startIndex][vertexList.get(i)];
			if (dist[i] == MAXPATH)
				prev[i] = -1;
			else
				prev[i] = 0;
		}
		
		
		hasVisited[0] = true;
		dist[0] = 0;
		
		
		for (int i = 1; i < dist.length; i++) {
			int minDist = MAXPATH;
			int u = 0;
			//找到当前距离startIndex最近并且为访问过的点
			for (int j = 1; j < dist.length; j++) {
				if (!hasVisited[j] && dist[j] < minDist) {
					u = j;
					minDist = dist[j];
				}
			}
			
			if (u == 0 || u == dist.length - 1)
				break;
			
			hasVisited[u] = true;
			//根据当前点u松弛节点
			for (int j = 1; j < dist.length; j++) {
				if (!hasVisited[j] && edges[vertexList.get(u)][vertexList.get(j)] < MAXPATH) {
					if (dist[u] + edges[vertexList.get(u)][vertexList.get(j)] < dist[j]) {
						dist[j] = dist[u] + edges[vertexList.get(u)][vertexList.get(j)];
						prev[j] = u;
					}
				}
			}
		}
		
		
		int length = MAXPATH;
		if (dist[vertexList.size() - 1] == MAXPATH) {
			
		} else {
			int i = vertexList.size() - 1;
			String pathStr = "";
			while (i != 0) {
				if (i == vertexList.size() - 1)
					pathStr = String.valueOf(edges[vertexList.get(prev[i])][vertexList.get(i)]);
				else {
					pathStr = String.valueOf(edges[vertexList.get(prev[i])][vertexList.get(i)]) + "|" + pathStr;
				}
				i = prev[i];
				//将otherV中的点保存下来
				pathVertexs.add(vertexList.get(i));				
			}
			
			length = dist[vertexList.size() - 1];
			
		}
		
		
		
		return length;
	}
	
    
    


}
