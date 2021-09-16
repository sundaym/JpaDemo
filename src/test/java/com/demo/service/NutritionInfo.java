package com.demo.service;

/**
 * Builder方式创建对象
 */
public class NutritionInfo {
    // 必须字段
    // 净含量
    private final int netWeight;

    // 可选字段
    // 卡路里
    private final int calories;
    // 脂肪
    private final int fat;
    // 钠
    private final int sodium;
    // 糖类
    private final int carbohydrate;

    public static class Builder {
        private final int netWeight;

        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int netWeight) {
            this.netWeight = netWeight;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionInfo build() {
            return new NutritionInfo(this);
        }
    }

    private NutritionInfo(Builder builder) {
        netWeight = builder.netWeight;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {
        System.out.println(1.00 - 9 * .10);
    }
}
