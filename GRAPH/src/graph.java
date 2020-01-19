import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

public class graph {

	public class vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	private HashMap<String, vertex> vces = new HashMap<>();

	public int numvertices() {
		return vces.size();
	}

	public boolean containsVertex(String vname) {
		return vces.containsKey(vname);
	}

	public void addVertex(String vname) {
		if (this.containsVertex(vname)) {
			return;
		}
		vertex vtx = new vertex();
		vces.put(vname, vtx);
	}

	public void removeVertex(String vname) {

		vertex vtx = vces.get(vname);
		Set<String> set = vtx.nbrs.keySet();
		for (String x : set) {
			vertex v = vces.get(x);
			v.nbrs.remove(vname);
		}
		vces.remove(vname);

	}

	public int numEdges() {
		int rv = 0;
		Set<String> vertexNames = vces.keySet();
		for (String vname : vertexNames) {
			vertex vtx = vces.get(vname);
			rv += vtx.nbrs.size();
		}
		return rv / 2;

	}

	public boolean containsEdge(String v1name, String v2name) {
		vertex vtx = vces.get(v1name);
		return vtx.nbrs.containsKey(v2name);

	}

	public void addEdge(String v1name, String v2name, int weight) {
		vertex vtx1 = vces.get(v1name);
		vertex vtx2 = vces.get(v2name);

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(v2name)) {
			return;
		}

		vtx2.nbrs.put(v1name, weight);
		vtx1.nbrs.put(v2name, weight);

	}

	public void removeEdge(String v1name, String v2name) {

		vertex vtx1 = vces.get(v1name);
		vtx1.nbrs.remove(v2name);

		vertex vtx2 = vces.get(v2name);
		vtx2.nbrs.remove(v1name);
	}

	public void display() {
		Set<String> nbrname = vces.keySet();

		for (String vn : nbrname) {
			vertex vtx = vces.get(vn);
			String str = vn + " -> ";
			Set<String> nbr = vtx.nbrs.keySet();
			for (String v : nbr) {
				str += v + "[" + vtx.nbrs.get(v) + "]";

			}
			System.out.println(str);
		}
	}

	public boolean hasPath(String v1name, String v2name, HashMap<String, Boolean> processed) {
		if (processed.containsKey(v1name)) {
			return false;
		}
		processed.put(v1name, true);
		if (containsEdge(v1name, v2name)) {
			return true;
		}
		vertex v = vces.get(v1name);
		Set<String> set = v.nbrs.keySet();
		for (String x : set) {
			if (hasPath(x, v2name, processed) == true) {
				return true;
			}
		}
		return false;
	}

	public boolean printPath(String v1name, String v2name, HashMap<String, Boolean> processed, String psf) {
		if (processed.containsKey(v1name)) {
			return false;
		}
		processed.put(v1name, true);
		psf += v1name + "=>";
		if (containsEdge(v1name, v2name)) {
			System.out.println(psf + v2name);
			return true;
		}
		vertex v = vces.get(v1name);
		Set<String> set = v.nbrs.keySet();
		for (String x : set) {
			if (printPath(x, v2name, processed, psf) == true) {
				return true;
			}
		}
		return false;
	}

}
