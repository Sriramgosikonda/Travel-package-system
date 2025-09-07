from rest_framework import serializers
from .models import Category, Package


class CategorySerializer(serializers.ModelSerializer):
    class Meta:
        model = Category
        fields = '__all__'


class PackageSerializer(serializers.ModelSerializer):
    category = CategorySerializer()

    class Meta:
        model = Package
        fields = '__all__'
