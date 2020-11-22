import java.util.HashSet;

public class BinNode<T extends Comparable<T>> extends AbstractBinNode<T> {

	public BinNode(T value, BinNode<T> child, BinNode<T> sibling) {
		super(value, child, sibling);
	}

	@Override
	public boolean isTree() {
		if (child != null) {
			if (value.compareTo(child.value) < 1)
				return child.isTree();
			else
				return false;
		} else if (sibling != null) {
			if (value.compareTo(sibling.value) < 1)
				return sibling.isTree();
			else
				return false;
		} else
			return true;
	}

	@Override
	public int getHeight() {
		if (!isTree()) {
			return -1;
		} else {
			int counter = 0;
			BinNode<T> next = child;
			while (next != null) {
				counter++;
				next = next.child;
			}
			return counter;
		}

	}

	@Override
	public int getBranchingFactor() {
		if (!isTree()) {
			return -1;
		}

		return 3;
	}

	@Override
	public boolean isBinaryTree() {
		return true;
	}

	@Override
	public boolean isBinarySearchTree() {
		return false;
	}

	@Override
	public boolean isAVLTree() {
		return false;
	}

	@Override
	public boolean isMinHeap() {
		return false;
	}

	@Override
	public boolean isMaxHeap() {
		return false;
	}

}
