# Import the required libraries
import torch
import hotshot_xl

# Load the Hotshot-XL model
model = hotshot_xl.load_model("hotshotco/Hotshot-XL")

# Load the fine-tuned SDXL model
sdxl = torch.hub.load('lucidrains/stable-diffusion-xl', 'stable_diffusion_xl', pretrained=True)

# Define the text prompt
prompt = "a cat playing with a ball of yarn"

# Generate the GIF
gif = model.generate(prompt, sdxl)

# Save the GIF
gif.save("cat.gif")
