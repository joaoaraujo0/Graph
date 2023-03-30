package ExemploGrafo;

import java.util.ArrayList;
import java.util.List;

public class GrafoExercicio {
 
    
    static class Vertice {
        String nome;
        List<Aresta> adj;
        Vertice(String nome) {
            this.nome = nome;
            this.adj = new ArrayList<Aresta>();
        }
        void addAdj(Aresta e) {
            adj.add(e);
        }
    }
     
    static class Aresta {
        Vertice origem;
        Vertice destino;
        Aresta(Vertice origem, Vertice destino) {
            this.origem = origem;
            this.destino = destino;
        }
    }
     
    List<Vertice> vertices;
    List<Aresta> arestas;
    
    public GrafoExercicio() {
        vertices = new ArrayList<Vertice>();
        arestas = new ArrayList<Aresta>();
    }
        
    Vertice addVertice(String nome) {
        Vertice v = new Vertice(nome);
        vertices.add(v);
        return v;
    }
     
    Aresta addAresta(Vertice origem, Vertice destino) {
        Aresta e = new Aresta(origem, destino);
        origem.addAdj(e);
        arestas.add(e);
        return e;
    }
    
    public String toString() {
        String r = "";
        for (Vertice u : vertices) {
            r += u.nome + " -> ";
            for (Aresta e : u.adj) {
                Vertice v = e.destino;
                r += v.nome + ", ";
            }
            r += "\n";
        }
        return r;
    }
    
    public boolean adjacente(Vertice u, Vertice v) {
        for (Aresta e : u.adj) {
            if (e.destino == v) {
                return true;
            }
        }
        return false;
    }
    
    public void vizinhos(Vertice x) {
    	
    }
	public void add_vertex(GrafoExercicio g,Vertice v) {
	    if(!g.vertices.contains(v)) {
	    	g.addVertice(v.nome);
	    	
	    }
	}
	
	public void remove_vertex(GrafoExercicio g, Vertice x) {
		if(vertices.contains(x)) {
			vertices.remove(x);
			System.out.println("Vertice "+'('+ x.nome + ')' + " Removido \n"); 
		}
	}
	public String get_vertex_value(Vertice x) {
		 return x.nome;
	}


    
    public static void main(String[] args) {
        GrafoExercicio g = new GrafoExercicio();
        Vertice s = g.addVertice("s");
        Vertice t = g.addVertice("t");
        Vertice y = g.addVertice("y");
        Aresta st = g.addAresta(s, t);
        Aresta sy = g.addAresta(s, y);
        Aresta ty = g.addAresta(t, y);
        Aresta yt = g.addAresta(y, t);
        System.out.println(g);
        System.out.println(g.adjacente(s, t)); 
        System.out.println(g.adjacente(s, y)); 
        System.out.println(g.adjacente(t, s)); 
        System.out.println("\n");
        g.vizinhos(s);
        Vertice v = new Vertice("v");
        g.add_vertex(g, v);
        System.out.println(g);
        g.remove_vertex(g,s);
        System.out.println(g);
        System.out.println("Nome: "+ g.get_vertex_value(s));
        
        
    }
}
