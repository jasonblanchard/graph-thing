interface Paths {
    public int getS();

    public boolean hasPathTo(int v);

    public Iterable<Integer> pathTo(int v);
}