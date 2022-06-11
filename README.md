## Technologies

* Java 11
* Spring boot rest API
* Mongo database ( using JPA)
* SMTP Java Mail
---
## Features

*   Register receiving email to be notified about stocks that are with a good price (either sell or buy):
    *   Register email through .txt files (it gets one e-mail per line);
    *   Register email through the API;

*   Register stocks (either Brazilian ticker or American ticker):
    *   Register through API and specify minimum and maximum price for that stock;

*    Scheduler that runs every minute to check on Yahoo API if the target price has been achieved. If so, a email is send to every email registered on the database telling about the stock operations it is supposed to do.

*   If a stock has already reached it's price, it will no longer be emailed again, until it goes back to the non desired price and go back to the target price. This way, the receiver won't keep getting emails about the same stock every minute.