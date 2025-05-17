import pandas as pd

# test_setup.py

def main():
    print("Hello, World!")
    print("Your Python environment is set up correctly.")

if __name__ == "__main__":
    main()

    import matplotlib.pyplot as plt

    # Create a simple DataFrame
    data = {
        'Category': ['A', 'B', 'C', 'D'],
        'Values': [10, 20, 15, 25]
    }
    df = pd.DataFrame(data)

    # Plot the data
    plt.bar(df['Category'], df['Values'], color='skyblue')
    plt.title('Sample Bar Graph')
    plt.xlabel('Category')
    plt.ylabel('Values')
    plt.show()