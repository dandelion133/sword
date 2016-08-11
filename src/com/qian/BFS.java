package com.qian;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class BFS {
	private static final int MAXPATH = Integer.MAX_VALUE;
	// �ڽӾ���洢ͼ
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
 
    // ������
    private int number = 9;
    // ��¼�����Ƿ񱻷���
    private boolean[] flag;
    // ����
    private String[] vertexs = { "A", "B", "C", "D", "E", "F", "G", "H", "I" };
    // ��
    private int[][] edges = {
            { 0, 1, 0, 0, 0, 1, 1, 0, 0 }, { 1, 0, 1, 0, 0, 0, 1, 0, 1 }, { 0, 1, 0, 1, 0, 0, 0, 0, 1 },
            { 0, 0, 1, 0, 1, 0, 1, 1, 1 }, { 0, 0, 0, 1, 0, 1, 0, 1, 0 }, { 1, 0, 0, 0, 1, 0, 1, 0, 0 },
            { 0, 1, 0, 1, 0, 1, 0, 1, 0 }, { 0, 0, 0, 1, 1, 0, 1, 0, 0 }, { 0, 1, 1, 1, 0, 0, 0, 0, 0 }
            };
 
    // ͼ����ȱ�������(�ݹ�)
    void DFSTraverse() {
        flag = new boolean[number];
        for (int i = 0; i < number; i++) {
            if (flag[i] == false) {// ��ǰ����û�б�����
                DFS(i);
            }
        }
    }
 
    // ͼ��������ȵݹ��㷨
    void DFS(int i) {
        flag[i] = true;// ��i�����㱻����
        System.out.print(vertexs[i] + " ");
        for (int j = 0; j < number; j++) {
            if (flag[j] == false && edges[i][j] == 1) {
                DFS(j);
            }
        }
    }
 
    // ͼ�Ĺ�ȱ�������
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
 
    // ����
    public static void main(String[] args) {
    	BFS graph = new BFS();
        System.out.println("ͼ����ȱ�������(�ݹ�):");
        graph.DFSTraverse();
        System.out.println("\n-------------");
        System.out.println("ͼ�Ĺ�ȱ�������:");
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
		//������е�
		vertexList.add(endIndex);
		
		/*System.out.println(vertexList);*/
		
		boolean[] hasVisited = new boolean[vertexList.size()];
		
		//����prev[]���飬����õ��Ӧ����ǰ�ڵ�
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
			//�ҵ���ǰ����startIndex�������Ϊ���ʹ��ĵ�
			for (int j = 1; j < dist.length; j++) {
				if (!hasVisited[j] && dist[j] < minDist) {
					u = j;
					minDist = dist[j];
				}
			}
			
			if (u == 0 || u == dist.length - 1)
				break;
			
			hasVisited[u] = true;
			//���ݵ�ǰ��u�ɳڽڵ�
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
				//��otherV�еĵ㱣������
				pathVertexs.add(vertexList.get(i));				
			}
			
			length = dist[vertexList.size() - 1];
			
		}
		
		
		
		return length;
	}
	
    
    


}
