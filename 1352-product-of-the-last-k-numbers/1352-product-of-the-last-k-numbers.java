class ProductOfNumbers {

    List<Integer> pref = new ArrayList<>();

    public ProductOfNumbers() {

    }

    public void add(int num) {

        if (num == 0) {
            pref.clear();
            return;
        }

        if (pref.size() == 0)
            pref.add(num);
        else
            pref.add(pref.get(pref.size() - 1) * num);
    }

    public int getProduct(int k) {

        if (k > pref.size())
            return 0;

        if (k == pref.size())
            return pref.get(pref.size() - 1);

        return pref.get(pref.size() - 1)
             / pref.get(pref.size() - k - 1);
    }
}