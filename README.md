# follow-bus-api

# FollowBus - Urban Mobility API

FollowBus is a backend API for real-time urban mobility tracking. It allows integration with mobile and web applications for users to find nearby bus lines, view vehicle positions in real time, and explore detailed route information.

> ⚠️ **Note**: The data used in this project is currently mock/test data and does not reflect actual transit information. However, the **core architecture and logic are the same** as what will be used for real data. The only difference will be **how data is sourced**, such as via **GTFS-rt feeds** or other real-time providers.

---

## 🚀 Features

- 📍 Get nearby bus lines based on latitude/longitude
- 🚌 Real-time vehicle tracking per line
- 🔁 Full route data with all associated stops
- 🧠 (Planned) Crowding estimation using Machine Learning
- 🧪 RESTful endpoints with Spring Boot
- 🗃️ PostgreSQL + UUID-based primary keys
