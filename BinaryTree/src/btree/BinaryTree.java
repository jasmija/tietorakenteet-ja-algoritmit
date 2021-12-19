/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package btree;

/**
 *
 * @author kamaj
 */
public class BinaryTree {

	private Node root;
	private BinaryTree temp;
	public static BinaryTree found;

	public BinaryTree(String rootValue) {
		root = new Node(rootValue);
	}

	public BinaryTree() {
		root = null;
	}

	public BinaryTree(String rootValue, BinaryTree left, BinaryTree right) {
		root = new Node(rootValue, left, right);
	}

	// Lisäys
	public void insert(String aData) {

		// jos root null luodaan uusi solmu
		if (root == null) {
			System.out.println("Root on null.. luodaan uusi solmu");
			root = new Node(aData);
			// muuten jo (ali)puun juuren avain > uusi avain
		} else if (root.getData().compareTo(aData) > 0) {
			if (root.left() != null) {
				System.out.println("Lisätään vasemmalle");
				root.left().insert(aData);
			} else {
				System.out.println(
						"Luodaan uusi alipuu, jonka sisältönä avain. Yhdistetään alipuu etsintäpuun solmun vasemmaksi alipuuksi.");
				// luodaan uusi alipuu (sisältönä avain)
				BinaryTree tree = new BinaryTree(aData);
				// yhdistetään alipuu etsintäpuun solmun vasemmaksi alipuuksi
				root.setLeft(tree);
			}
		} else {
			if (root.right() != null) {
				System.out.println("Lisätään oikealle");
				root.right().insert(aData);
			} else {
				System.out.println(
						"Luodaan uusi alipuu, jonka sisältönä avain. Yhdistetään alipuu etsintäpuun solmun oikeaksi alipuuksi.");
				// luodaan uusi alipuu (sisältönä avain)
				BinaryTree tree = new BinaryTree(aData);
				// yhdistetään alipuu etsintäpuun solmun oikeaksi alipuuksi
				root.setRight(tree);
			}
		}
	}

	// Haku
	public BinaryTree find(String aData) {

		// onko avain rootissa
		if (root == null) {
			System.out.println("Puu tyhjä!");
			return null;
		} else if (root.getData().equals(aData)) {
			return this;
		}
		// onko avain pienempi kuin root (vasemmalla)
		else if (root.getData().compareTo(aData) > 0) {
			System.out.println("haettu < root");
			// System.out.println("Haettu avain: " + tree.root.getData());
			if (root.left() == null) {
				return null;
			} else {
				System.out.println("Korkeus " + root.getDepth());
				return root.left().find(aData);
			}
			// onko avain isompi kuin root (oikealla)
		} else {
			System.out.println("haettu > root");
			// System.out.println("Haettu avain: " + tree.root.getData());
			if (root.right() == null) {
				return null;
			} else {
				System.out.println("Korkeus " + root.getDepth());
				return root.right().find(aData);
			}
		}
	}

	// Poisto
	public BinaryTree delete(BinaryTree root, String data) {
		
		if(root == null) {
			return null;
		}
		if (root.root.getData().compareTo(data) > 0) {
			System.out.println("haettu < root");
			root.setLeft(delete(root.root.left(), data));
		} else if (root.root.getData().compareTo(data) < 0) {
			System.out.println("haettu > root");
			root.root.setRight(delete(root.root.right(), data));
		} else {
			if (root.root.left() == null && root.root.right() == null) {
				// Solmulla ei alipuuta
				System.out.println("Poistettavalla solmulla ei alipuita. Poistetaan " + data + ".");
				root = null;
			} else if(root.root.left() != null && root.root.right() != null) {
				// Solmulla kaksi alipuuta
				System.out.println("Poistettavalla kaksi alipuuta. Poistetaan " + data + ".");
				BinaryTree temp = findMax(root.root.left());
				root.root.setData(temp.root.getData());
				root.setLeft(delete(root.root.left(), temp.root.getData()));
			} else if (root.root.left() != null) {
				// Solmulla ei oikeaa alipuuta
				System.out.println("Poistettavalla solmulla ei oikeaa alipuuta. Poistetaan " + data + ".");
				BinaryTree children = root.root.left();
				System.out.println(root.root.getData());
				root = children;
			} else {
				// Solmulla ei vasenta alipuuta
				System.out.println("Poistettavalla solmulla ei vasenta alipuuta. Poistetaan " + data + ".");
				BinaryTree children = root.root.right();
				System.out.println(root.root.getData());
				root = children;
			}	
		}
		return root;
		

		// Tapaus 1: ei alipuita:
		// Jos poistettavalla solmulla ei ole alipuita poista solmu.

		// Tapaus 2: yksi alipuu:
		// Jos poistettavalla solmulla on joko vasen tai oikea alipuu, niin yhdistä
		// alipuu solmun vanhempaan (samalle puolelle, jolla poistettava solmu on)
		// poista solmu.

		// Tapaus 3: kaksi alipuuta
		// Jos poistettavalla solmulla on molemmat alipuut, niin etsi solmun
		// oikeanpuoleisen alipuun vasemmanpuoleisin solmu (Huom: toteutettu jo aiemmin)
		// ja kopioi sen datakenttä poistettavan solmun datakentäksi. Poista tämä
		// oikeanpuoleisen alipuun vasen solmu.

	}
	
	private BinaryTree findMax(BinaryTree tree) {
		 while(tree.root.right() != null) {
	            tree = tree.root.right();
	        }
	        return tree;
	}

	public void preOrder() {
		if (root != null) {
			System.out.println(root.getData() + ',');
			if (root.left() != null) // pääseeekö vasemmalle?
				root.left().preOrder();
			if (root.right() != null) // pääseekö oikealle?
				root.right().preOrder();
		}

	}

	public void setLeft(BinaryTree tree) {
		root.setLeft(tree);
	}

	public void setRight(BinaryTree tree) {
		root.setRight(tree);
	}

}
