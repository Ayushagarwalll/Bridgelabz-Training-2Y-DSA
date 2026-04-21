
public class problem1 {
	public static long totalSize(FileNode node) {
		return totalSize(node, new java.util.HashSet<>());
	}

	private static long totalSize(FileNode node, java.util.Set<String> visited) {
		if (node == null) {
			return 0L;
		}
		if (node.isSymbolicLink || visited.contains(node.path)) {
			return 0L;
		}
		if (node.isFile) {
			return node.sizeKb;
		}

		visited.add(node.path);
		long sum = 0L;
		for (FileNode child : node.children) {
			sum += totalSize(child, visited);
		}
		visited.remove(node.path);
		return sum;
	}

	static final class FileNode {
		final String path;
		final boolean isFile;
		final boolean isSymbolicLink;
		final long sizeKb;
		final java.util.List<FileNode> children;

		FileNode(String path, boolean isFile, boolean isSymbolicLink, long sizeKb, java.util.List<FileNode> children) {
			this.path = path;
			this.isFile = isFile;
			this.isSymbolicLink = isSymbolicLink;
			this.sizeKb = sizeKb;
			this.children = children == null ? java.util.Collections.emptyList() : children;
		}
	}
}
