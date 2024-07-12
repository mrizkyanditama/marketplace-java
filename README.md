# Marketplace Project

This repository contains the code and configuration files for a Marketplace application, which consists of two main components: an Order Service and a Product Service. The application is designed to run using Docker Compose.

## Prerequisites

- Docker
- Docker Compose

## Getting Started

1. Clone the repository:


git clone https://github.com/your-username/marketplace-project.git


2. Navigate to the project directory:


cd marketplace-project


3. Build the Docker images:


docker-compose build


4. Start the containers:

docker-compose up


This will start the following containers:

- `postgres`: PostgreSQL database for the Order Service
- `postgres2`: PostgreSQL database for the Product Service
- `order_backend`: Spring Boot application for the Order Service
- `product_backend`: Spring Boot application for the Product Service

## Services
# Order Controller

This controller handles the creation of orders in the Marketplace application.

## Base URL
/api/orders


## Endpoints

### Create Order

Creates a new order in the system.

- **URL**: `/create`
- **Method**: `POST`
- **Request Body**:
  ```json
    {
        "customerId": 1234,
        "orderItems": [
            {
                "productId": "1234",
                "price": 50.00,
                "quantity": 2
            },
            {
                "productId": "2345",
                "price": 25.00,
                "quantity": 3
            }
        ]
    }

# Product Controller

This controller handles the retrieval of products in the Marketplace application.

## Base URL
/api/products


## Endpoints

### Get Products

Retrieves a list of products based on the provided tag names or product IDs.

- **URL**: `/`
- **Method**: `GET`
- **Query Parameters**:
  - `tagNames` (optional): A comma-separated list of tag names to filter products by.
  - `productIds` (optional): A comma-separated list of product IDs to retrieve specific products.
- **Success Response**:
  - **Code**: 200 OK
  - **Content**:
    ```json
    [
      {
        "id": 1,
        "name": "Product 1",
        "description": "This is product 1",
        "price": 9.99,
        "tags": ["tag1", "tag2"]
      },
      {
        "id": 2,
        "name": "Product 2",
        "description": "This is product 2",
        "price": 19.99,
        "tags": ["tag2", "tag3"]
      }
    ]
    ```

## Query Parameters

- `tagNames` (optional): A comma-separated list of tag names to filter products by. If provided, the controller will retrieve products that match any of the specified tag names.
- `productIds` (optional): A comma-separated list of product IDs to retrieve specific products. If provided, the controller will retrieve products that match any of the specified product IDs.

If both `tagNames` and `productIds` are provided, the controller will prioritize `tagNames` and retrieve products based on the specified tag names.

## Response

The response for a successful product retrieval will be a JSON array of product objects, each containing the following fields:

- `id` (number): The unique identifier of the product.
- `name` (string): The name of the product.
- `description` (string): The description of the product.
- `price` (number): The price of the product.
- `tags` (array): An array of strings representing the tags associated with the product.
