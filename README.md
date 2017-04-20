# API

## Merchant

- Get all merchants

```GET /merchant```

- Get merchant by merchant ID

```GET /merchant/{merchantId}```

- Create/update merchant

```POST /merchant```

with body:

```
{
    "merchantId": 3, // this is mandatory only when updating an existing merchant
	"name": "product x",
	"image": "image x",
	"price": 3.4
}
```

- Delete merchant

```DELETE /merchant/{merchantId}```

## Product

- Get all products

```GET /product```

- Get product by product ID

```GET /product/{productId}```

- Get product catalogue by merchant ID

```GET /product/merchant/{merchantId}```

- Get products by beacon ID

```GET /product/beacon/{beaconId}```

- Create/update product

```POST /product```

with body:

```
{
  "productId": 1, // this is only mandatory when updating an existing product 
  "name": "product name",
  "image": "url to image",
  "merchantId": 3,
  "price": 45.3,
}
```

- Add product to beacon

```POST /product/beacon```

with body:

```
{
    "beaconId": {
        "productId": 1,
        "beaconId": 2
    }
}
```

- Delete product

```DELETE /product/{merchantId}```

- Delete beacon from product

```DELETE /product/{productId}/beacon/{beaconId}```