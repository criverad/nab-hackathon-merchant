# API

Pivotal Cloud Foundry End point as follows FOR MERCHANT API

```http://nabhackathon-merchant.cfapps.io```

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
    "beaconProductId": {
        "productId": 1,
        "beaconId": "beacon-w"
    }
}
```

- Delete product

```DELETE /product/{merchantId}```

- Delete beacon from product

```DELETE /product/{productId}/beacon/{beaconId}```

## Payment

- Get all payments

```GET /payment```

- Get payment by payment ID

```GET /payment/{paymentId}```

- Get payments by merchant ID

```GET /payment/merchant/{merchantId}```

- Get payments by beacon ID

```GET /payment/beacon/{beaconId}```

- Get payments by customer ID

```GET /payment/customer/{customerId}```

- Create/update payment

```POST /payment```

with body:

```
{
    "paymentId": 1, // this is only required for payment updates
	"amount": 0.5,
	"description": "payment description",
	"date": "2012-04-23T18:25:43.511Z",
	"outcome": "SUCCESS",
	"beaconId": "beacon-id-1",
	"customerId": 1,
	"merchantId": 2
}
```

- Delete payment

```DELETE /payment/{paymentId}```

## Customer

- Get all customer

```GET /customer```

- Get customer by customer ID

```GET /customer/{customerId}```

- Create/update customer

```POST /customer```

with body:

```
{
    "customerId": 1, // this is only required for customer updates
	"image": "customer image",
	"name": "customer name"
}
```

- Delete customer

```DELETE /customer/{customerId}```

# Environment Setup

## MySQL

Local database needs to be setup by running the following SQL statements:

```
CREATE DATABASE merchant;
CREATE USER 'merchant'@'localhost' IDENTIFIED BY 'merchant';
GRANT ALL PRIVILEGES ON *.* TO 'merchant'@'localhost' WITH GRANT OPTION;
```
