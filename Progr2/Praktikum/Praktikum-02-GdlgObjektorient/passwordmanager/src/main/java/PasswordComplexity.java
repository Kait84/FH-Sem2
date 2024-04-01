private class PasswordComplexity {

        char[] chars = new char[];

        char[] Ziffern = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        char[] Kleinbuchst = {a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z};
        char[] Grossbuchst = {A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z};
        char[] Sonderz = {!, ?, +, -, ;, ,, ., :};
         int length;
         char ordinal;
         enum name {
             PIN,
             SIMPLE,
             MEDIUM,
             COMPLEX,
             SUPER_Complex
         }

         public String generatePassword() {

         }
         public getLength(int length) {
            return this.length;
         }
         public PasswordComplexity(enum name) {
            this.name = name;
         }
}
